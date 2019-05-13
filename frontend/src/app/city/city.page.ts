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
    this._cityService.get(id).subscribe(suc => {
      this.form.value.date = suc.date;
      this.form.value.driver = this.formatObject(suc.driver);
      this.form.value.car = this.formatObject(suc.car);
      this.form.value.startKm = suc.startKm;
      this.form.value.endKm = suc.endKm;
      this.form.value.otherKm = suc.otherKm;
      this.form.value.totalReceived = suc.totalReceived;
    });
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
