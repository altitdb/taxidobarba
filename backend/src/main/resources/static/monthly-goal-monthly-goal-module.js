(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["monthly-goal-monthly-goal-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/monthly-goal/monthly-goal.page.html":
/*!*******************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/monthly-goal/monthly-goal.page.html ***!
  \*******************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<ion-header>\n  <ion-toolbar>\n    <ion-buttons slot=\"start\">\n      <ion-menu-button></ion-menu-button>\n    </ion-buttons>\n    <ion-title>\n      Taxi do Barba\n    </ion-title>\n  </ion-toolbar>\n</ion-header>\n\n<ion-content>\n  <ion-grid>\n    <ion-row>\n      <ion-col class=\"ion-text-center\">\n        Data\n      </ion-col>\n      <ion-col class=\"ion-text-center\">\n        Meta\n      </ion-col>\n      <ion-col class=\"ion-text-center\">\n        Anterior\n      </ion-col>\n      <ion-col class=\"ion-text-center\">\n        Atual\n      </ion-col>\n      <ion-col class=\"ion-text-center\">\n        %\n      </ion-col>\n    </ion-row>\n    <ion-row *ngFor=\"let item of report\">\n      <ion-item-divider color=\"light\">\n        <ion-col class=\"ion-text-center\">\n          {{ item.date }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ item.goal | currency }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ item.lastMonth | currency }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ item.actualMonth | currency }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ item.percentage | number: '2.2-2' }}\n        </ion-col>\n      </ion-item-divider>\n    </ion-row>\n    <ion-row>\n      <ion-item-divider color=\"light\">\n        <ion-col class=\"ion-text-center\">\n          Total\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ summary && summary.goal | currency }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ summary && summary.lastMonth | currency }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ summary && summary.actualMonth | currency }}\n        </ion-col>\n        <ion-col class=\"ion-text-end\">\n          {{ summary && summary.percentage | number: '2.2-2' }}\n        </ion-col>\n      </ion-item-divider>\n    </ion-row>\n  </ion-grid>\n</ion-content>\n");

/***/ }),

/***/ "./src/app/monthly-goal/monthly-goal.module.ts":
/*!*****************************************************!*\
  !*** ./src/app/monthly-goal/monthly-goal.module.ts ***!
  \*****************************************************/
/*! exports provided: MonthlyGoalPageModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonthlyGoalPageModule", function() { return MonthlyGoalPageModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm5/router.js");
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ionic/angular */ "./node_modules/@ionic/angular/__ivy_ngcc__/fesm5/ionic-angular.js");
/* harmony import */ var _monthly_goal_page__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./monthly-goal.page */ "./src/app/monthly-goal/monthly-goal.page.ts");
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
        component: _monthly_goal_page__WEBPACK_IMPORTED_MODULE_5__["MonthlyGoalPage"]
    }
];
var MonthlyGoalPageModule = /** @class */ (function () {
    function MonthlyGoalPageModule() {
    }
    MonthlyGoalPageModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                _ionic_angular__WEBPACK_IMPORTED_MODULE_4__["IonicModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forChild(routes)
            ],
            declarations: [_monthly_goal_page__WEBPACK_IMPORTED_MODULE_5__["MonthlyGoalPage"]]
        })
    ], MonthlyGoalPageModule);
    return MonthlyGoalPageModule;
}());



/***/ }),

/***/ "./src/app/monthly-goal/monthly-goal.page.scss":
/*!*****************************************************!*\
  !*** ./src/app/monthly-goal/monthly-goal.page.scss ***!
  \*****************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21vbnRobHktZ29hbC9tb250aGx5LWdvYWwucGFnZS5zY3NzIn0= */");

/***/ }),

/***/ "./src/app/monthly-goal/monthly-goal.page.ts":
/*!***************************************************!*\
  !*** ./src/app/monthly-goal/monthly-goal.page.ts ***!
  \***************************************************/
/*! exports provided: MonthlyGoalPage */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonthlyGoalPage", function() { return MonthlyGoalPage; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _monthly_goal_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./monthly-goal.service */ "./src/app/monthly-goal/monthly-goal.service.ts");
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


var MonthlyGoalPage = /** @class */ (function () {
    function MonthlyGoalPage(_monthlyGoalService) {
        this._monthlyGoalService = _monthlyGoalService;
    }
    MonthlyGoalPage.prototype.ngOnInit = function () {
        this.getReport();
    };
    MonthlyGoalPage.prototype.getReport = function () {
        var _this = this;
        this._monthlyGoalService.get().subscribe(function (suc) {
            _this.report = suc.goal;
            _this.summary = suc.summary;
        });
    };
    MonthlyGoalPage.ctorParameters = function () { return [
        { type: _monthly_goal_service__WEBPACK_IMPORTED_MODULE_1__["MonthlyGoalService"] }
    ]; };
    MonthlyGoalPage = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-monthly-goal',
            template: __importDefault(__webpack_require__(/*! raw-loader!./monthly-goal.page.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/monthly-goal/monthly-goal.page.html")).default,
            styles: [__importDefault(__webpack_require__(/*! ./monthly-goal.page.scss */ "./src/app/monthly-goal/monthly-goal.page.scss")).default]
        }),
        __metadata("design:paramtypes", [_monthly_goal_service__WEBPACK_IMPORTED_MODULE_1__["MonthlyGoalService"]])
    ], MonthlyGoalPage);
    return MonthlyGoalPage;
}());



/***/ }),

/***/ "./src/app/monthly-goal/monthly-goal.service.ts":
/*!******************************************************!*\
  !*** ./src/app/monthly-goal/monthly-goal.service.ts ***!
  \******************************************************/
/*! exports provided: MonthlyGoalService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonthlyGoalService", function() { return MonthlyGoalService; });
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



var MonthlyGoalService = /** @class */ (function () {
    function MonthlyGoalService(_httpClient) {
        this._httpClient = _httpClient;
        this.url = src_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].baseUrl + '/api/v1/monthly-goal';
    }
    MonthlyGoalService.prototype.get = function () {
        var HEADERS = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]().set('Content-Type', 'application/json');
        return this._httpClient.get(this.url, {
            headers: HEADERS
        });
    };
    MonthlyGoalService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    MonthlyGoalService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], MonthlyGoalService);
    return MonthlyGoalService;
}());



/***/ })

}]);
//# sourceMappingURL=monthly-goal-monthly-goal-module.js.map