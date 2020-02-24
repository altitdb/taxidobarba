import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { CarService } from "../service/car.service";
import { DriverService } from "../service/driver.service";
import { FuelService } from "./fuel.service";
import * as moment from "moment";
import { ModalController } from "@ionic/angular";
import { ModalPage } from "./modal/modal.page";
import { ActivatedRoute } from "@angular/router";
import { CommonCashRegister } from "../page/common-cash-register.page";

@Component({
  selector: "app-fuel",
  templateUrl: "./fuel.page.html",
  styleUrls: ["./fuel.page.scss"]
})
export class FuelPage extends CommonCashRegister implements OnInit {
  drivers: Array<Driver>;
  cars: Array<Car>;
  form: FormGroup;
  response: FuelResponse;

  constructor(
    public _driverService: DriverService,
    public _carService: CarService,
    private _formBuilder: FormBuilder,
    private _fuelService: FuelService,
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
      price: [null, Validators.required],
      liters: [null, Validators.required]
    });
    this.getDrivers();
    this.getCars();
    this.updateForm();
  }

  updateForm() {
    let id = this._route.snapshot.paramMap.get("id");
    if (id !== null) {
      this._fuelService.get(id).subscribe(suc => {
        this.form.patchValue({
          data: suc.date,
          driver: this.formatObject(suc.driver),
          car: this.formatObject(suc.car),
          price: suc.price,
          liters: suc.liters
        });
      });
    }
  }

  save() {
    this.form.value.date = moment(this.form.value.date).format("YYYY-MM-DD");
    let id = this._route.snapshot.paramMap.get("id");
    if (id === null) {
      this._fuelService.save(this.form.value).subscribe(suc => {
        this.presentModal(suc);
        this.form.reset();
      });
    } else {
      this._fuelService.update(id, this.form.value).subscribe(suc => {
        this.presentModal(suc);
        this.form.reset();
      });
    }
    
  }

  async presentModal(response: FuelResponse) {
    const modal = await this._modalController.create({
      component: ModalPage,
      componentProps: { response }
    });
    return await modal.present();
  }
}
