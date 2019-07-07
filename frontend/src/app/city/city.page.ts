import { Component, OnInit } from "@angular/core";
import { CityService } from "./city.service";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { DriverService } from "../service/driver.service";
import { CarService } from "../service/car.service";
import * as moment from "moment";
import { ModalController } from "@ionic/angular";
import { ModalPage } from "./modal/modal.page";
import { ActivatedRoute } from "@angular/router";
import { CommonCashRegister } from "../page/common-cash-register.page";

@Component({
  selector: "app-city",
  templateUrl: "./city.page.html",
  styleUrls: ["./city.page.scss"]
})
export class CityPage extends CommonCashRegister implements OnInit {
  drivers: Array<Driver>;
  cars: Array<Car>;
  form: FormGroup;

  constructor(
    public _driverService: DriverService,
    public _carService: CarService,
    private _formBuilder: FormBuilder,
    private _cityService: CityService,
    private _modalController: ModalController,
    private _route: ActivatedRoute
  ) {
    super(_driverService, _carService);
  }

  ngOnInit() {
    this.form = this._formBuilder.group({
      date: [new Date().toISOString(), Validators.required],
      driver: [null, Validators.required],
      car: [null, Validators.required],
      startKm: [null, Validators.required],
      endKm: [null, Validators.required],
      otherKm: [null, Validators.required],
      totalReceived: [null, Validators.required]
    });
    this.getDrivers();
    this.getCars();
    this.updateForm();
  }

  updateForm() {
    let id = this._route.snapshot.paramMap.get("id");
    if (id !== null) {
      this._cityService.get(id).subscribe(suc => {
        this.form.patchValue({
          date: suc.date,
          driver: this.formatObject(suc.driver),
          car: this.formatObject(suc.car),
          startKm: suc.startKm,
          endKm: suc.endKm,
          otherKm: suc.otherKm,
          totalReceived: suc.totalReceived
        });
        this.form.value.id = suc.id;
      });
    }
  }

  formatObject(object) {
    if (object === null) {
      return null;
    }
    return object.id;
  }

  save() {
    this.form.value.date = moment(this.form.value.date).format("YYYY-MM-DD");
    this._cityService.save(this.form.value).subscribe(suc => {
      this.presentModal(suc);
      this.form.reset();
    });
  }

  async presentModal(response: CityResponse) {
    const modal = await this._modalController.create({
      component: ModalPage,
      componentProps: { response }
    });
    return await modal.present();
  }
}
