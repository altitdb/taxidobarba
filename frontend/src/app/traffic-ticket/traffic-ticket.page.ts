import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { DriverService } from "../service/driver.service";
import { CarService } from "../service/car.service";
import * as moment from "moment";
import { ModalController } from "@ionic/angular";
import { ModalPage } from "./modal/modal.page";
import { ActivatedRoute } from "@angular/router";
import { TrafficTicketService } from "./traffic-ticket.service";
import { CommonCashRegister } from "../page/common-cash-register.page";
@Component({
  selector: 'app-traffic-ticket',
  templateUrl: './traffic-ticket.page.html',
  styleUrls: ['./traffic-ticket.page.scss'],
})
export class TrafficTicketPage extends CommonCashRegister implements OnInit {

  drivers: Array<Driver>;
  cars: Array<Car>;
  form: FormGroup;
  response: String;

  constructor(
    public _driverService: DriverService,
    public _carService: CarService,
    private _formBuilder: FormBuilder,
    private _trafficTicketService: TrafficTicketService,
    private _modalController: ModalController,
    private _route: ActivatedRoute
  ) {
    super(_driverService, _carService);
  }

  ngOnInit() {
    this.form = this._formBuilder.group({
      dueDate: [new Date().toISOString(), Validators.required],
      driver: [null, Validators.required],
      car: [null, Validators.required],
      value: [null, Validators.required],
      points: [null, Validators.required]
    });
    this.getDrivers();
    this.getCars();
    this.updateForm();
  }

  updateForm() {
    let id = this._route.snapshot.paramMap.get("id");
    if (id !== null) {
      this._trafficTicketService.getAll().subscribe(suc => {
        this.form.patchValue({
          dueDate: suc.dueDate,
          driver: this.formatObject(suc.driver),
          car: this.formatObject(suc.car),
          value: suc.value,
          paidValue: suc.paidValue,
          status: suc.status
        });
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
    this.form.value.dueDate = moment(this.form.value.dueDate).format("YYYY-MM-DD");
    this._trafficTicketService.save(this.form.value).subscribe((result: any) => {
      this.presentModal("Salvo com sucesso!");
      this.form.reset();
    }, (result: any) => {
      this.presentModal(result.error.message);
    });
  }

  async presentModal(response: String) {
    const modal = await this._modalController.create({
      component: ModalPage,
      componentProps: { response }
    });
    return await modal.present();
  }

}
