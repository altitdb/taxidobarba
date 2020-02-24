(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["annual-summary-annual-summary-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/annual-summary/annual-summary.page.html":
/*!***********************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/annual-summary/annual-summary.page.html ***!
  \***********************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<ion-header>\n  <ion-toolbar>\n    <ion-buttons slot=\"start\">\n      <ion-menu-button></ion-menu-button>\n    </ion-buttons>\n    <ion-title>\n      Taxi do Barba\n    </ion-title>\n  </ion-toolbar>\n</ion-header>\n\n<ion-content>\n  <ion-grid>\n    <ion-row>\n      <ion-col class=\"ion-text-center\">\n        Mês\n      </ion-col>\n      <ion-col class=\"ion-text-center\">\n        Valor Bruto\n      </ion-col>\n      <ion-col class=\"ion-text-center\">\n        Valor Líquido\n      </ion-col>\n    </ion-row>\n    <ion-row *ngFor=\"let item of report\">\n      <ion-item-divider color=\"light\">\n        <ion-col class=\"ion-text-center\">\n          {{ item.month }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ item.grossValue }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ item.netValue }}\n        </ion-col>\n      </ion-item-divider>\n    </ion-row>\n    <ion-row>\n      <ion-item-divider color=\"light\">\n        <ion-col class=\"ion-text-center\">\n          Total\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ amount && amount.grossValue }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ amount && amount.netValue }}\n        </ion-col>\n      </ion-item-divider>\n    </ion-row>\n  </ion-grid>\n</ion-content>\n");

/***/ }),

/***/ "./src/app/annual-summary/annual-summary.module.ts":
/*!*********************************************************!*\
  !*** ./src/app/annual-summary/annual-summary.module.ts ***!
  \*********************************************************/
/*! exports provided: AnnualSummaryPageModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AnnualSummaryPageModule", function() { return AnnualSummaryPageModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm5/router.js");
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ionic/angular */ "./node_modules/@ionic/angular/__ivy_ngcc__/fesm5/ionic-angular.js");
/* harmony import */ var _annual_summary_page__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./annual-summary.page */ "./src/app/annual-summary/annual-summary.page.ts");
/* harmony import */ var _annual_summary_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./annual-summary.service */ "./src/app/annual-summary/annual-summary.service.ts");
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
        path: "",
        component: _annual_summary_page__WEBPACK_IMPORTED_MODULE_5__["AnnualSummaryPage"]
    }
];
var AnnualSummaryPageModule = /** @class */ (function () {
    function AnnualSummaryPageModule() {
    }
    AnnualSummaryPageModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                _ionic_angular__WEBPACK_IMPORTED_MODULE_4__["IonicModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forChild(routes)
            ],
            declarations: [_annual_summary_page__WEBPACK_IMPORTED_MODULE_5__["AnnualSummaryPage"]],
            providers: [_annual_summary_service__WEBPACK_IMPORTED_MODULE_6__["AnnualSummaryService"]]
        })
    ], AnnualSummaryPageModule);
    return AnnualSummaryPageModule;
}());



/***/ }),

/***/ "./src/app/annual-summary/annual-summary.page.scss":
/*!*********************************************************!*\
  !*** ./src/app/annual-summary/annual-summary.page.scss ***!
  \*********************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FubnVhbC1zdW1tYXJ5L2FubnVhbC1zdW1tYXJ5LnBhZ2Uuc2NzcyJ9 */");

/***/ }),

/***/ "./src/app/annual-summary/annual-summary.page.ts":
/*!*******************************************************!*\
  !*** ./src/app/annual-summary/annual-summary.page.ts ***!
  \*******************************************************/
/*! exports provided: AnnualSummaryPage */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AnnualSummaryPage", function() { return AnnualSummaryPage; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _annual_summary_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./annual-summary.service */ "./src/app/annual-summary/annual-summary.service.ts");
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


var AnnualSummaryPage = /** @class */ (function () {
    function AnnualSummaryPage(_annualSummaryService) {
        this._annualSummaryService = _annualSummaryService;
    }
    AnnualSummaryPage.prototype.ngOnInit = function () {
        this.getReport();
    };
    AnnualSummaryPage.prototype.getReport = function () {
        var _this = this;
        this._annualSummaryService.get().subscribe(function (suc) {
            _this.report = suc.annualSummary;
            _this.amount = suc.amount;
        });
    };
    AnnualSummaryPage.ctorParameters = function () { return [
        { type: _annual_summary_service__WEBPACK_IMPORTED_MODULE_1__["AnnualSummaryService"] }
    ]; };
    AnnualSummaryPage = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-annual-summary',
            template: __importDefault(__webpack_require__(/*! raw-loader!./annual-summary.page.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/annual-summary/annual-summary.page.html")).default,
            styles: [__importDefault(__webpack_require__(/*! ./annual-summary.page.scss */ "./src/app/annual-summary/annual-summary.page.scss")).default]
        }),
        __metadata("design:paramtypes", [_annual_summary_service__WEBPACK_IMPORTED_MODULE_1__["AnnualSummaryService"]])
    ], AnnualSummaryPage);
    return AnnualSummaryPage;
}());



/***/ }),

/***/ "./src/app/annual-summary/annual-summary.service.ts":
/*!**********************************************************!*\
  !*** ./src/app/annual-summary/annual-summary.service.ts ***!
  \**********************************************************/
/*! exports provided: AnnualSummaryService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AnnualSummaryService", function() { return AnnualSummaryService; });
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



var AnnualSummaryService = /** @class */ (function () {
    function AnnualSummaryService(_httpClient) {
        this._httpClient = _httpClient;
        this.url = src_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].baseUrl + '/api/v1/annual-summary';
    }
    AnnualSummaryService.prototype.get = function () {
        var HEADERS = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]().set('Content-Type', 'application/json');
        return this._httpClient.get(this.url, {
            headers: HEADERS
        });
    };
    AnnualSummaryService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    AnnualSummaryService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], AnnualSummaryService);
    return AnnualSummaryService;
}());



/***/ })

}]);
//# sourceMappingURL=annual-summary-annual-summary-module.js.map