import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CarService } from '../service/car.service';
import { DriverService } from '../service/driver.service';
import { TravelService } from './travel.service';
import { ModalController } from '@ionic/angular';
import * as moment from 'moment';
import { ModalPage } from './modal/modal.page';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-travel',
  templateUrl: './travel.page.html',
  styleUrls: ['./travel.page.scss'],
})
export class TravelPage implements OnInit {

  form: FormGroup;
  response: TravelResponse;
  drivers: Array<Driver>;
  cars: Array<Car>;

  constructor(private _formBuilder: FormBuilder,
              private _travelService: TravelService,
              private _driverService: DriverService,
              private _carService: CarService,
              private _modalController: ModalController,
              private _route: ActivatedRoute
              ) { }

  ngOnInit() {
    this.form = this._formBuilder.group({
      date: [new Date().toISOString(), Validators.required],
      driver: [null, Validators.required],
      car: [null, Validators.required],
      km: [null, Validators.required],
      price: [null, Validators.required],
      city: [null, Validators.required],
    });
    this.getDrivers();
    this.getCars();
    this.updateForm();
  }

  updateForm() {
    let id = this._route.snapshot.paramMap.get('id');
    this._travelService.get(id).subscribe(suc => {
      this.form.value.date = suc.date;
      this.form.value.driver = this.formatObject(suc.driver);
      this.form.value.car = this.formatObject(suc.car);
      this.form.value.km = suc.km;
      this.form.value.price = suc.price;
      this.form.value.city = suc.city;
    });
  }

  formatObject(object) {
    if (object === null) {
      return null;
    }
    return object.id;
  }

  save() {
    this.form.value.date = moment(this.form.value.date).format('YYYY-MM-DD');
    this._travelService.save(this.form.value).subscribe(suc => {
      this.presentModal(suc);
      this.form.reset();
    });
  }

  async presentModal(response: TravelResponse) {
    const modal = await this._modalController.create({
      component: ModalPage,
      componentProps: { response }
    });
    return await modal.present();
  }

  getDrivers() {
    this._driverService.getActive().subscribe(suc => {
      this.drivers = suc;
    });
  }

  getCars() {
    this._carService.getActive().subscribe(suc => {
      this.cars = suc;
    });
  }

}
