import { Component, OnInit } from '@angular/core';
import { NavParams, ModalController } from '@ionic/angular';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.page.html',
  styleUrls: ['./modal.page.scss'],
})
export class ModalPage implements OnInit {

  response: any;

  constructor(navParams: NavParams, private _modalController: ModalController) { 
    this.response = navParams.data;
  }
  
  ngOnInit() {
  }

  public async close() {
    const modal = await this._modalController.getTop();
    modal.dismiss();
  }
}
