(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["driver-driver-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/driver/driver.page.html":
/*!*******************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/driver/driver.page.html ***!
  \*******************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<ion-header>\n  <ion-toolbar>\n    <ion-buttons slot=\"start\">\n      <ion-menu-button></ion-menu-button>\n    </ion-buttons>\n    <ion-title>\n      Taxi do Barba\n    </ion-title>\n  </ion-toolbar>\n</ion-header>\n\n<ion-content>\n  <ion-list>\n    <ion-item *ngFor=\"let item of drivers\">\n      <ion-avatar item-left>\n        <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1Gevu4Tk803Ydc4VywH_ANoJSf3B6rnuI64IChMJSdw9qfR7s\">\n      </ion-avatar>\n      <h2>{{item.name}}</h2>\n    </ion-item>\n  </ion-list>\n</ion-content>\n\n");

/***/ }),

/***/ "./src/app/driver/driver.module.ts":
/*!*****************************************!*\
  !*** ./src/app/driver/driver.module.ts ***!
  \*****************************************/
/*! exports provided: DriverPageModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DriverPageModule", function() { return DriverPageModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm5/router.js");
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ionic/angular */ "./node_modules/@ionic/angular/__ivy_ngcc__/fesm5/ionic-angular.js");
/* harmony import */ var _driver_page__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./driver.page */ "./src/app/driver/driver.page.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/http.js");
/* harmony import */ var _service_driver_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../service/driver.service */ "./src/app/service/driver.service.ts");
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
        component: _driver_page__WEBPACK_IMPORTED_MODULE_5__["DriverPage"]
    }
];
var DriverPageModule = /** @class */ (function () {
    function DriverPageModule() {
    }
    DriverPageModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                _ionic_angular__WEBPACK_IMPORTED_MODULE_4__["IonicModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forChild(routes),
                _angular_common_http__WEBPACK_IMPORTED_MODULE_6__["HttpClientModule"]
            ],
            declarations: [_driver_page__WEBPACK_IMPORTED_MODULE_5__["DriverPage"]],
            providers: [
                _service_driver_service__WEBPACK_IMPORTED_MODULE_7__["DriverService"]
            ]
        })
    ], DriverPageModule);
    return DriverPageModule;
}());



/***/ }),

/***/ "./src/app/driver/driver.page.scss":
/*!*****************************************!*\
  !*** ./src/app/driver/driver.page.scss ***!
  \*****************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2RyaXZlci9kcml2ZXIucGFnZS5zY3NzIn0= */");

/***/ }),

/***/ "./src/app/driver/driver.page.ts":
/*!***************************************!*\
  !*** ./src/app/driver/driver.page.ts ***!
  \***************************************/
/*! exports provided: DriverPage */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DriverPage", function() { return DriverPage; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _service_driver_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../service/driver.service */ "./src/app/service/driver.service.ts");
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


var DriverPage = /** @class */ (function () {
    function DriverPage(_driverService) {
        this._driverService = _driverService;
    }
    DriverPage.prototype.ngOnInit = function () {
        this.getDrivers();
    };
    DriverPage.prototype.getDrivers = function () {
        var _this = this;
        this._driverService.get()
            .subscribe(function (suc) {
            _this.drivers = suc;
        });
    };
    DriverPage.ctorParameters = function () { return [
        { type: _service_driver_service__WEBPACK_IMPORTED_MODULE_1__["DriverService"] }
    ]; };
    DriverPage = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-driver',
            template: __importDefault(__webpack_require__(/*! raw-loader!./driver.page.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/driver/driver.page.html")).default,
            styles: [__importDefault(__webpack_require__(/*! ./driver.page.scss */ "./src/app/driver/driver.page.scss")).default]
        }),
        __metadata("design:paramtypes", [_service_driver_service__WEBPACK_IMPORTED_MODULE_1__["DriverService"]])
    ], DriverPage);
    return DriverPage;
}());



/***/ })

}]);
//# sourceMappingURL=driver-driver-module.js.map