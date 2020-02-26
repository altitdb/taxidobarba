(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["monthly-summary-monthly-summary-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/monthly-summary/monthly-summary.page.html":
/*!*************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/monthly-summary/monthly-summary.page.html ***!
  \*************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<ion-header>\n  <ion-toolbar>\n    <ion-buttons slot=\"start\">\n      <ion-menu-button></ion-menu-button>\n    </ion-buttons>\n    <ion-title>\n      Taxi do Barba\n    </ion-title>\n  </ion-toolbar>\n</ion-header>\n\n<ion-content padding>\n  <ion-item> Mês {{ report?.date }} </ion-item>\n  <ion-card>\n    <ion-card-header>\n      <ion-card-title>Resumo</ion-card-title>\n    </ion-card-header>\n\n    <ion-card-content>\n      <ion-item> Valor bruto: {{ report?.summary.grossValue | currency }} </ion-item>\n      <ion-item> Valor líquido: {{ report?.summary.netValue | currency }} </ion-item>\n      <ion-item> Valor esperado: {{ report?.summary.averageDayValue | currency }} </ion-item>\n    </ion-card-content>\n  </ion-card>\n\n  <ion-card>\n    <ion-card-header>\n      <ion-card-title>KM Rodados</ion-card-title>\n    </ion-card-header>\n\n    <ion-card-content>\n      <ion-item> KM Cidade: {{ report?.km.kmRolledCity }} </ion-item>\n      <ion-item> KM Viagem: {{ report?.km.kmRolledTravel }} </ion-item>\n      <ion-item> KM Total: {{ report?.km.amountKmRolled }} </ion-item>\n    </ion-card-content>\n  </ion-card>\n\n  <ion-card>\n    <ion-card-header>\n      <ion-card-title>Consumo</ion-card-title>\n    </ion-card-header>\n\n    <ion-card-content>\n      <ion-item>\n        KM por Litro: {{ report?.consumption.litersPerKm | number }}\n      </ion-item>\n      <ion-item>\n        KM Médio por Dia: {{ report?.consumption.averageKmPerDay | number }}\n      </ion-item>\n      <ion-item>\n        Preço Médio por KM: {{ report?.consumption.averagePriceSpentPerKm | currency }}\n      </ion-item>\n      <ion-item>\n        Preço Médio por Litro: {{ report?.consumption.averagePriceFuel | currency }}\n      </ion-item>\n      <ion-item>\n        Valor Médio por Dia: {{ report?.consumption.averagePricePerDay | currency }}\n      </ion-item>\n    </ion-card-content>\n  </ion-card>\n\n  <ion-card>\n    <ion-card-header>\n      <ion-card-title>Cartões</ion-card-title>\n    </ion-card-header>\n\n    <ion-card-content>\n      <ion-card>\n        <ion-card-header>\n          <ion-card-title>Débito</ion-card-title>\n        </ion-card-header>\n\n        <ion-card-content>\n          <ion-item> Valor Bruto: {{ report?.card.debit.grossValue }} </ion-item>\n          <ion-item> Valor Taxa: {{ report?.card.debit.taxValue }} </ion-item>\n          <ion-item> Valor Líquido: {{ report?.card.debit.netValue }} </ion-item>\n        </ion-card-content>\n      </ion-card>\n      <ion-card>\n        <ion-card-header>\n          <ion-card-title>Crédito</ion-card-title>\n        </ion-card-header>\n\n        <ion-card-content>\n          <ion-item>\n            Valor Bruto: {{ report?.card.credit.grossValue }}\n          </ion-item>\n          <ion-item> \n            Valor Taxa: {{ report?.card.credit.taxValue }}\n          </ion-item>\n          <ion-item>\n            Valor Líquido: {{ report?.card.credit.netValue }}\n          </ion-item>\n        </ion-card-content>\n      </ion-card>\n      <ion-card>\n        <ion-card-header>\n          <ion-card-title>Resumo</ion-card-title>\n        </ion-card-header>\n\n        <ion-card-content>\n          <ion-item>\n            Valor Líquido: {{ report?.card.summary.netValue }}\n          </ion-item>\n          <ion-item>\n            Valor Taxa: {{ report?.card.summary.taxValue }}\n          </ion-item>\n          <ion-item>\n            Percentual Recebimento: {{ report?.card.summary.percent }}\n          </ion-item>\n        </ion-card-content>\n      </ion-card>\n    </ion-card-content>\n  </ion-card>\n\n  <ion-card>\n    <ion-card-header>\n      <ion-card-title>Gastos</ion-card-title>\n    </ion-card-header>\n\n    <ion-card-content>\n      <ion-item> Combustível: {{ report?.spent.fuel }} </ion-item>\n      <ion-item> Outros: {{ report?.spent.others }} </ion-item>\n      <ion-item> Total: {{ report?.spent.amount }} </ion-item>\n    </ion-card-content>\n  </ion-card>\n\n  <ion-card>\n    <ion-card-header>\n      <ion-card-title>Motoristas</ion-card-title>\n    </ion-card-header>\n\n    <ion-card-content>\n      <ion-card *ngFor=\"let item of report?.driver\">\n        <ion-card-header>\n          <ion-card-title>{{ item.name }}</ion-card-title>\n        </ion-card-header>\n\n        <ion-card-content>\n          <ion-item> Média Diária: {{ item.average | currency }} </ion-item>\n          <ion-item> Valor Total: {{ item.amount | currency }} </ion-item>\n          <ion-item> Percentual: {{ item.percentage | number: '2.2-2' }} </ion-item>\n        </ion-card-content>\n      </ion-card>\n    </ion-card-content>\n  </ion-card>\n</ion-content>\n");

/***/ }),

/***/ "./src/app/monthly-summary/monthly-summary.module.ts":
/*!***********************************************************!*\
  !*** ./src/app/monthly-summary/monthly-summary.module.ts ***!
  \***********************************************************/
/*! exports provided: MonthlySummaryPageModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonthlySummaryPageModule", function() { return MonthlySummaryPageModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm5/router.js");
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ionic/angular */ "./node_modules/@ionic/angular/__ivy_ngcc__/fesm5/ionic-angular.js");
/* harmony import */ var _monthly_summary_page__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./monthly-summary.page */ "./src/app/monthly-summary/monthly-summary.page.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __importDefault = (undefined && undefined.__importDefault) || function (mod) {
  return (mod && mod.__esModule) ? mod : { "default": mod };
};






var routes = [
    {
        path: '',
        component: _monthly_summary_page__WEBPACK_IMPORTED_MODULE_5__["MonthlySummaryPage"]
    }
];
var MonthlySummaryPageModule = /** @class */ (function () {
    function MonthlySummaryPageModule() {
    }
    MonthlySummaryPageModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                _ionic_angular__WEBPACK_IMPORTED_MODULE_4__["IonicModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forChild(routes)
            ],
            declarations: [_monthly_summary_page__WEBPACK_IMPORTED_MODULE_5__["MonthlySummaryPage"]]
        })
    ], MonthlySummaryPageModule);
    return MonthlySummaryPageModule;
}());



/***/ }),

/***/ "./src/app/monthly-summary/monthly-summary.page.scss":
/*!***********************************************************!*\
  !*** ./src/app/monthly-summary/monthly-summary.page.scss ***!
  \***********************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21vbnRobHktc3VtbWFyeS9tb250aGx5LXN1bW1hcnkucGFnZS5zY3NzIn0= */");

/***/ }),

/***/ "./src/app/monthly-summary/monthly-summary.page.ts":
/*!*********************************************************!*\
  !*** ./src/app/monthly-summary/monthly-summary.page.ts ***!
  \*********************************************************/
/*! exports provided: MonthlySummaryPage */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonthlySummaryPage", function() { return MonthlySummaryPage; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _monthly_summary_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./monthly-summary.service */ "./src/app/monthly-summary/monthly-summary.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __importDefault = (undefined && undefined.__importDefault) || function (mod) {
  return (mod && mod.__esModule) ? mod : { "default": mod };
};


var MonthlySummaryPage = /** @class */ (function () {
    function MonthlySummaryPage(_monthlySummaryService) {
        this._monthlySummaryService = _monthlySummaryService;
    }
    MonthlySummaryPage.prototype.ngOnInit = function () {
        this.getReport();
    };
    MonthlySummaryPage.prototype.getReport = function () {
        var _this = this;
        this._monthlySummaryService.get().subscribe(function (suc) {
            _this.report = suc;
        });
    };
    MonthlySummaryPage.ctorParameters = function () { return [
        { type: _monthly_summary_service__WEBPACK_IMPORTED_MODULE_1__["MonthlySummaryService"] }
    ]; };
    MonthlySummaryPage = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-monthly-summary',
            template: __importDefault(__webpack_require__(/*! raw-loader!./monthly-summary.page.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/monthly-summary/monthly-summary.page.html")).default,
            styles: [__importDefault(__webpack_require__(/*! ./monthly-summary.page.scss */ "./src/app/monthly-summary/monthly-summary.page.scss")).default]
        }),
        __metadata("design:paramtypes", [_monthly_summary_service__WEBPACK_IMPORTED_MODULE_1__["MonthlySummaryService"]])
    ], MonthlySummaryPage);
    return MonthlySummaryPage;
}());



/***/ }),

/***/ "./src/app/monthly-summary/monthly-summary.service.ts":
/*!************************************************************!*\
  !*** ./src/app/monthly-summary/monthly-summary.service.ts ***!
  \************************************************************/
/*! exports provided: MonthlySummaryService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonthlySummaryService", function() { return MonthlySummaryService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/http.js");
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __importDefault = (undefined && undefined.__importDefault) || function (mod) {
  return (mod && mod.__esModule) ? mod : { "default": mod };
};



var MonthlySummaryService = /** @class */ (function () {
    function MonthlySummaryService(_httpClient) {
        this._httpClient = _httpClient;
        this.url = src_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].baseUrl + "/api/v1/actual-month-summary";
    }
    MonthlySummaryService.prototype.get = function () {
        var HEADERS = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]().set("Content-Type", "application/json");
        return this._httpClient.get(this.url, {
            headers: HEADERS
        });
    };
    MonthlySummaryService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    MonthlySummaryService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: "root"
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], MonthlySummaryService);
    return MonthlySummaryService;
}());



/***/ })

}]);
//# sourceMappingURL=monthly-summary-monthly-summary-module.js.map