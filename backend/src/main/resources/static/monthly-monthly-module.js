(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["monthly-monthly-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/monthly/monthly.page.html":
/*!*********************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/monthly/monthly.page.html ***!
  \*********************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<ion-header>\n  <ion-toolbar>\n    <ion-buttons slot=\"start\">\n      <ion-menu-button></ion-menu-button>\n    </ion-buttons>\n    <ion-title>\n      Taxi do Barba\n    </ion-title>\n  </ion-toolbar>\n</ion-header>\n\n<ion-content>\n  <ion-item>\n    <ion-label>Período</ion-label>\n  <ion-datetime display-format=\"MM/YYYY\" picker-format=\"MM/YYYY\" [(ngModel)]=\"datetime\" (ionChange)=\"filterDate()\"></ion-datetime>\n  </ion-item>\n  <ion-grid>\n    <ion-row>\n      <ion-col class=\"ion-text-center\">\n        Data\n      </ion-col>\n      <ion-col class=\"ion-text-center\">\n        Tipo\n      </ion-col>\n      <ion-col class=\"ion-text-center\">\n        Motorista\n      </ion-col>\n      <ion-col class=\"ion-text-center\">\n        Valor\n      </ion-col>\n      <ion-col class=\"ion-text-center\">\n        Editar\n      </ion-col>\n    </ion-row>\n    <ion-row *ngFor=\"let item of report\">\n      <ion-item-divider color=\"light\">\n        <ion-col class=\"ion-text-center\">\n          {{ item.date }}\n        </ion-col>\n        <ion-col class=\"ion-text-center\">\n          {{ item.type }}\n        </ion-col>\n        <ion-col class=\"ion-text-center\">\n          {{ item.id === null ? '' : item.driver.split(\" \")[0] }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ item.value }}\n        </ion-col>\n        <ion-col class=\"ion-text-center\">\n          <ion-button (click)=\"update(item.id, item.type)\" [disabled]=\"item.id === null\">\n            <ion-icon slot=\"icon-only\" name=\"create\"></ion-icon>\n          </ion-button>\n        </ion-col>\n      </ion-item-divider>\n    </ion-row>\n  </ion-grid>\n  <ion-item>\n    <div class=\"ion-text-end\">\n      Valor Bruto {{ amount && amount.grossValue }}\n    </div>\n  </ion-item>\n  <ion-item>\n    <div class=\"ion-text-end\">\n      Total Líquido {{ amount && amount.netValue }}\n    </div>\n  </ion-item>\n</ion-content>\n");

/***/ }),

/***/ "./src/app/monthly/monthly.module.ts":
/*!*******************************************!*\
  !*** ./src/app/monthly/monthly.module.ts ***!
  \*******************************************/
/*! exports provided: MonthlyPageModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonthlyPageModule", function() { return MonthlyPageModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm5/router.js");
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ionic/angular */ "./node_modules/@ionic/angular/__ivy_ngcc__/fesm5/ionic-angular.js");
/* harmony import */ var _monthly_page__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./monthly.page */ "./src/app/monthly/monthly.page.ts");
/* harmony import */ var _monthly_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./monthly.service */ "./src/app/monthly/monthly.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/http.js");
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
        component: _monthly_page__WEBPACK_IMPORTED_MODULE_5__["MonthlyPage"]
    }
];
var MonthlyPageModule = /** @class */ (function () {
    function MonthlyPageModule() {
    }
    MonthlyPageModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                _ionic_angular__WEBPACK_IMPORTED_MODULE_4__["IonicModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forChild(routes),
                _angular_common_http__WEBPACK_IMPORTED_MODULE_7__["HttpClientModule"]
            ],
            declarations: [_monthly_page__WEBPACK_IMPORTED_MODULE_5__["MonthlyPage"]],
            providers: [
                _monthly_service__WEBPACK_IMPORTED_MODULE_6__["MonthlyService"]
            ]
        })
    ], MonthlyPageModule);
    return MonthlyPageModule;
}());



/***/ }),

/***/ "./src/app/monthly/monthly.page.scss":
/*!*******************************************!*\
  !*** ./src/app/monthly/monthly.page.scss ***!
  \*******************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21vbnRobHkvbW9udGhseS5wYWdlLnNjc3MifQ== */");

/***/ }),

/***/ "./src/app/monthly/monthly.page.ts":
/*!*****************************************!*\
  !*** ./src/app/monthly/monthly.page.ts ***!
  \*****************************************/
/*! exports provided: MonthlyPage */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonthlyPage", function() { return MonthlyPage; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _monthly_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./monthly.service */ "./src/app/monthly/monthly.service.ts");
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! moment */ "./node_modules/moment/moment.js");
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(moment__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm5/router.js");
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




var MonthlyPage = /** @class */ (function () {
    function MonthlyPage(_monthlyService, _router) {
        this._monthlyService = _monthlyService;
        this._router = _router;
        this.datetime = new Date().toISOString();
    }
    MonthlyPage.prototype.ngOnInit = function () {
        this.getDrivers();
    };
    MonthlyPage.prototype.getDrivers = function () {
        var _this = this;
        var month = moment__WEBPACK_IMPORTED_MODULE_2__(this.datetime).format("MM");
        var year = moment__WEBPACK_IMPORTED_MODULE_2__(this.datetime).format("YYYY");
        this._monthlyService.get(month, year)
            .subscribe(function (suc) {
            _this.report = suc.report;
            _this.amount = suc.amount;
        });
    };
    MonthlyPage.prototype.update = function (id, type) {
        if (type === 'CITY') {
            this._router.navigateByUrl("/city/" + id);
        }
        else if (type === 'TRAVEL') {
            this._router.navigateByUrl("/travel/" + id);
        }
        else if (type === 'FUEL') {
            this._router.navigateByUrl("/fuel/" + id);
        }
    };
    MonthlyPage.prototype.filterDate = function () {
        this.getDrivers();
    };
    MonthlyPage.ctorParameters = function () { return [
        { type: _monthly_service__WEBPACK_IMPORTED_MODULE_1__["MonthlyService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"] }
    ]; };
    MonthlyPage = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-monthly',
            template: __importDefault(__webpack_require__(/*! raw-loader!./monthly.page.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/monthly/monthly.page.html")).default,
            styles: [__importDefault(__webpack_require__(/*! ./monthly.page.scss */ "./src/app/monthly/monthly.page.scss")).default]
        }),
        __metadata("design:paramtypes", [_monthly_service__WEBPACK_IMPORTED_MODULE_1__["MonthlyService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
    ], MonthlyPage);
    return MonthlyPage;
}());



/***/ }),

/***/ "./src/app/monthly/monthly.service.ts":
/*!********************************************!*\
  !*** ./src/app/monthly/monthly.service.ts ***!
  \********************************************/
/*! exports provided: MonthlyService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonthlyService", function() { return MonthlyService; });
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



var MonthlyService = /** @class */ (function () {
    function MonthlyService(_httpClient) {
        this._httpClient = _httpClient;
        this.url = src_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].baseUrl + '/api/v1/monthly-report';
    }
    MonthlyService.prototype.get = function (month, year) {
        return this._httpClient.get(this.url + "?month=" + month + "&year=" + year);
    };
    MonthlyService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    MonthlyService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], MonthlyService);
    return MonthlyService;
}());



/***/ })

}]);
//# sourceMappingURL=monthly-monthly-module.js.map