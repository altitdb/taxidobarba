(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["city-city-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/city/city.page.html":
/*!***************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/city/city.page.html ***!
  \***************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<ion-header>\n  <ion-toolbar>\n    <ion-buttons slot=\"start\">\n      <ion-menu-button></ion-menu-button>\n    </ion-buttons>\n    <ion-title>\n      Taxi do Barba\n    </ion-title>\n  </ion-toolbar>\n</ion-header>\n\n<ion-content [formGroup]=\"form\">\n  <ion-item>\n    <ion-label>Data</ion-label>\n    <ion-datetime\n      display-format=\"DD/MM/YYYY\"\n      picker-format=\"DD/MM/YYYY\"\n      formControlName=\"date\"\n    ></ion-datetime>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>Motorista</ion-label>\n    <ion-select placeholder=\"Selecione\" formControlName=\"driver\">\n      <ion-select-option *ngFor=\"let item of drivers\" value=\"{{item.id}}\">{{item.name}}</ion-select-option>\n    </ion-select>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>Carro</ion-label>\n    <ion-select placeholder=\"Selecione\" formControlName=\"car\">\n      <ion-select-option *ngFor=\"let item of cars\" value=\"{{item.id}}\">{{item.name}}</ion-select-option>\n    </ion-select>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>KM Inicial</ion-label>\n    <ion-input type=\"number\" formControlName=\"startKm\"></ion-input>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>KM Final</ion-label>\n    <ion-input type=\"number\" formControlName=\"endKm\"></ion-input>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>Outros KM</ion-label>\n    <ion-input type=\"number\" formControlName=\"otherKm\"></ion-input>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>Total Recebido</ion-label>\n    <ion-input type=\"number\" formControlName=\"totalReceived\"></ion-input>\n  </ion-item>\n\n  <ion-item>\n    <ion-button (click)=\"form.reset()\">Limpar</ion-button>\n    <ion-button (click)=\"save()\" [disabled]=\"!form.valid\">Salvar</ion-button>\n  </ion-item>\n</ion-content>\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/city/modal/modal.page.html":
/*!**********************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/city/modal/modal.page.html ***!
  \**********************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<ion-header>\n  <ion-toolbar>\n    <ion-buttons slot=\"start\">\n      <ion-menu-button></ion-menu-button>\n    </ion-buttons>\n    <ion-title>\n      Taxi do Barba\n    </ion-title>\n    <ion-buttons slot=\"end\">\n      <ion-button (click)=\"close()\">Fechar</ion-button>\n    </ion-buttons>\n  </ion-toolbar>\n</ion-header>\n\n<ion-content>\n  <ion-item>\n    <ion-label>Data</ion-label>\n    <ion-label>{{response.date}}</ion-label>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>Motorista</ion-label>\n    <ion-label>{{response.driver.name}}</ion-label>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>Carro</ion-label>\n    <ion-label>{{response.car.name}}</ion-label>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>KM Inicial</ion-label>\n    <ion-label>{{response.startKm}}</ion-label>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>KM Final</ion-label>\n    <ion-label>{{response.endKm}}</ion-label>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>Outros KM</ion-label>\n    <ion-label>{{response.otherKm}}</ion-label>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>KM Utilizado</ion-label>\n    <ion-label>{{response.km}}</ion-label>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>Diferença</ion-label>\n    <ion-label>{{response.difference}}</ion-label>\n  </ion-item>\n\n  <ion-item>\n    <ion-label>Total Recebido</ion-label>\n    <ion-label>{{response.totalReceived}}</ion-label>\n  </ion-item>\n</ion-content>\n");

/***/ }),

/***/ "./src/app/city/city.module.ts":
/*!*************************************!*\
  !*** ./src/app/city/city.module.ts ***!
  \*************************************/
/*! exports provided: CityPageModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CityPageModule", function() { return CityPageModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm5/router.js");
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ionic/angular */ "./node_modules/@ionic/angular/__ivy_ngcc__/fesm5/ionic-angular.js");
/* harmony import */ var _city_page__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./city.page */ "./src/app/city/city.page.ts");
/* harmony import */ var _city_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./city.service */ "./src/app/city/city.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/http.js");
/* harmony import */ var _service_car_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../service/car.service */ "./src/app/service/car.service.ts");
/* harmony import */ var _service_driver_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../service/driver.service */ "./src/app/service/driver.service.ts");
/* harmony import */ var _modal_modal_page__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./modal/modal.page */ "./src/app/city/modal/modal.page.ts");
/* harmony import */ var _modal_modal_module__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./modal/modal.module */ "./src/app/city/modal/modal.module.ts");
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
        component: _city_page__WEBPACK_IMPORTED_MODULE_5__["CityPage"]
    },
    {
        path: ":id",
        component: _city_page__WEBPACK_IMPORTED_MODULE_5__["CityPage"]
    }
];
var CityPageModule = /** @class */ (function () {
    function CityPageModule() {
    }
    CityPageModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                _ionic_angular__WEBPACK_IMPORTED_MODULE_4__["IonicModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forChild(routes),
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_7__["HttpClientModule"],
                _modal_modal_module__WEBPACK_IMPORTED_MODULE_11__["ModalPageModule"]
            ],
            declarations: [_city_page__WEBPACK_IMPORTED_MODULE_5__["CityPage"]],
            providers: [_city_service__WEBPACK_IMPORTED_MODULE_6__["CityService"], _service_driver_service__WEBPACK_IMPORTED_MODULE_9__["DriverService"], _service_car_service__WEBPACK_IMPORTED_MODULE_8__["CarService"]],
            entryComponents: [_modal_modal_page__WEBPACK_IMPORTED_MODULE_10__["ModalPage"]]
        })
    ], CityPageModule);
    return CityPageModule;
}());



/***/ }),

/***/ "./src/app/city/city.page.scss":
/*!*************************************!*\
  !*** ./src/app/city/city.page.scss ***!
  \*************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2NpdHkvY2l0eS5wYWdlLnNjc3MifQ== */");

/***/ }),

/***/ "./src/app/city/city.page.ts":
/*!***********************************!*\
  !*** ./src/app/city/city.page.ts ***!
  \***********************************/
/*! exports provided: CityPage */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CityPage", function() { return CityPage; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _city_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./city.service */ "./src/app/city/city.service.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm5/forms.js");
/* harmony import */ var _service_driver_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../service/driver.service */ "./src/app/service/driver.service.ts");
/* harmony import */ var _service_car_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../service/car.service */ "./src/app/service/car.service.ts");
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! moment */ "./node_modules/moment/moment.js");
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(moment__WEBPACK_IMPORTED_MODULE_5__);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ "./node_modules/@ionic/angular/__ivy_ngcc__/fesm5/ionic-angular.js");
/* harmony import */ var _modal_modal_page__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./modal/modal.page */ "./src/app/city/modal/modal.page.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm5/router.js");
/* harmony import */ var _page_common_cash_register_page__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../page/common-cash-register.page */ "./src/app/page/common-cash-register.page.ts");
var __extends = (undefined && undefined.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __awaiter = (undefined && undefined.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (undefined && undefined.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
var __importDefault = (undefined && undefined.__importDefault) || function (mod) {
  return (mod && mod.__esModule) ? mod : { "default": mod };
};










var CityPage = /** @class */ (function (_super) {
    __extends(CityPage, _super);
    function CityPage(_driverService, _carService, _formBuilder, _cityService, _modalController, _route) {
        var _this = _super.call(this, _driverService, _carService) || this;
        _this._driverService = _driverService;
        _this._carService = _carService;
        _this._formBuilder = _formBuilder;
        _this._cityService = _cityService;
        _this._modalController = _modalController;
        _this._route = _route;
        return _this;
    }
    CityPage.prototype.ngOnInit = function () {
        this.form = this._formBuilder.group({
            date: [new Date().toISOString(), _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            driver: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            car: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            startKm: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            endKm: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            otherKm: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            totalReceived: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]
        });
        this.getDrivers();
        this.getCars();
        this.updateForm();
    };
    CityPage.prototype.updateForm = function () {
        var _this = this;
        var id = this._route.snapshot.paramMap.get("id");
        if (id !== null) {
            this._cityService.get(id).subscribe(function (suc) {
                _this.form.patchValue({
                    date: suc.date,
                    driver: _this.formatObject(suc.driver),
                    car: _this.formatObject(suc.car),
                    startKm: suc.startKm,
                    endKm: suc.endKm,
                    otherKm: suc.otherKm,
                    totalReceived: suc.totalReceived
                });
            });
        }
    };
    CityPage.prototype.formatObject = function (object) {
        if (object === null) {
            return null;
        }
        return object.id;
    };
    CityPage.prototype.save = function () {
        var _this = this;
        this.form.value.date = moment__WEBPACK_IMPORTED_MODULE_5__(this.form.value.date).format("YYYY-MM-DD");
        var id = this._route.snapshot.paramMap.get("id");
        if (id === null) {
            this._cityService.save(this.form.value).subscribe(function (suc) {
                _this.presentModal(suc);
                _this.form.reset();
            });
        }
        else {
            this._cityService.update(id, this.form.value).subscribe(function (suc) {
                _this.presentModal(suc);
                _this.form.reset();
            });
        }
    };
    CityPage.prototype.presentModal = function (response) {
        return __awaiter(this, void 0, void 0, function () {
            var modal;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this._modalController.create({
                            component: _modal_modal_page__WEBPACK_IMPORTED_MODULE_7__["ModalPage"],
                            componentProps: { response: response }
                        })];
                    case 1:
                        modal = _a.sent();
                        return [4 /*yield*/, modal.present()];
                    case 2: return [2 /*return*/, _a.sent()];
                }
            });
        });
    };
    CityPage.ctorParameters = function () { return [
        { type: _service_driver_service__WEBPACK_IMPORTED_MODULE_3__["DriverService"] },
        { type: _service_car_service__WEBPACK_IMPORTED_MODULE_4__["CarService"] },
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: _city_service__WEBPACK_IMPORTED_MODULE_1__["CityService"] },
        { type: _ionic_angular__WEBPACK_IMPORTED_MODULE_6__["ModalController"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_8__["ActivatedRoute"] }
    ]; };
    CityPage = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: "app-city",
            template: __importDefault(__webpack_require__(/*! raw-loader!./city.page.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/city/city.page.html")).default,
            styles: [__importDefault(__webpack_require__(/*! ./city.page.scss */ "./src/app/city/city.page.scss")).default]
        }),
        __metadata("design:paramtypes", [_service_driver_service__WEBPACK_IMPORTED_MODULE_3__["DriverService"],
            _service_car_service__WEBPACK_IMPORTED_MODULE_4__["CarService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _city_service__WEBPACK_IMPORTED_MODULE_1__["CityService"],
            _ionic_angular__WEBPACK_IMPORTED_MODULE_6__["ModalController"],
            _angular_router__WEBPACK_IMPORTED_MODULE_8__["ActivatedRoute"]])
    ], CityPage);
    return CityPage;
}(_page_common_cash_register_page__WEBPACK_IMPORTED_MODULE_9__["CommonCashRegister"]));



/***/ }),

/***/ "./src/app/city/city.service.ts":
/*!**************************************!*\
  !*** ./src/app/city/city.service.ts ***!
  \**************************************/
/*! exports provided: CityService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CityService", function() { return CityService; });
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



var CityService = /** @class */ (function () {
    function CityService(_httpClient) {
        this._httpClient = _httpClient;
        this.url = src_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].baseUrl + '/api/v1/cash/city';
        this.HEADERS = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]().set('Content-Type', 'application/json');
    }
    CityService.prototype.save = function (data) {
        return this._httpClient.post(this.url, data, {
            headers: this.HEADERS
        });
    };
    CityService.prototype.update = function (id, data) {
        return this._httpClient.put(this.url + "/" + id, data, {
            headers: this.HEADERS
        });
    };
    CityService.prototype.get = function (id) {
        return this._httpClient.get(this.url + "/" + id, {
            headers: this.HEADERS
        });
    };
    CityService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    CityService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], CityService);
    return CityService;
}());



/***/ }),

/***/ "./src/app/city/modal/modal.module.ts":
/*!********************************************!*\
  !*** ./src/app/city/modal/modal.module.ts ***!
  \********************************************/
/*! exports provided: ModalPageModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ModalPageModule", function() { return ModalPageModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm5/forms.js");
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ionic/angular */ "./node_modules/@ionic/angular/__ivy_ngcc__/fesm5/ionic-angular.js");
/* harmony import */ var _modal_page__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./modal.page */ "./src/app/city/modal/modal.page.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __importDefault = (undefined && undefined.__importDefault) || function (mod) {
  return (mod && mod.__esModule) ? mod : { "default": mod };
};





var ModalPageModule = /** @class */ (function () {
    function ModalPageModule() {
    }
    ModalPageModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                _ionic_angular__WEBPACK_IMPORTED_MODULE_3__["IonicModule"],
            ],
            declarations: [_modal_page__WEBPACK_IMPORTED_MODULE_4__["ModalPage"]]
        })
    ], ModalPageModule);
    return ModalPageModule;
}());



/***/ }),

/***/ "./src/app/city/modal/modal.page.scss":
/*!********************************************!*\
  !*** ./src/app/city/modal/modal.page.scss ***!
  \********************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2NpdHkvbW9kYWwvbW9kYWwucGFnZS5zY3NzIn0= */");

/***/ }),

/***/ "./src/app/city/modal/modal.page.ts":
/*!******************************************!*\
  !*** ./src/app/city/modal/modal.page.ts ***!
  \******************************************/
/*! exports provided: ModalPage */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ModalPage", function() { return ModalPage; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm5/core.js");
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @ionic/angular */ "./node_modules/@ionic/angular/__ivy_ngcc__/fesm5/ionic-angular.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __awaiter = (undefined && undefined.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (undefined && undefined.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
var __importDefault = (undefined && undefined.__importDefault) || function (mod) {
  return (mod && mod.__esModule) ? mod : { "default": mod };
};


var ModalPage = /** @class */ (function () {
    function ModalPage(navParams, _modalController) {
        this._modalController = _modalController;
        this.response = navParams.data;
    }
    ModalPage.prototype.ngOnInit = function () {
    };
    ModalPage.prototype.close = function () {
        return __awaiter(this, void 0, void 0, function () {
            var modal;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this._modalController.getTop()];
                    case 1:
                        modal = _a.sent();
                        modal.dismiss();
                        return [2 /*return*/];
                }
            });
        });
    };
    ModalPage.ctorParameters = function () { return [
        { type: _ionic_angular__WEBPACK_IMPORTED_MODULE_1__["NavParams"] },
        { type: _ionic_angular__WEBPACK_IMPORTED_MODULE_1__["ModalController"] }
    ]; };
    ModalPage = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-modal',
            template: __importDefault(__webpack_require__(/*! raw-loader!./modal.page.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/city/modal/modal.page.html")).default,
            styles: [__importDefault(__webpack_require__(/*! ./modal.page.scss */ "./src/app/city/modal/modal.page.scss")).default]
        }),
        __metadata("design:paramtypes", [_ionic_angular__WEBPACK_IMPORTED_MODULE_1__["NavParams"], _ionic_angular__WEBPACK_IMPORTED_MODULE_1__["ModalController"]])
    ], ModalPage);
    return ModalPage;
}());



/***/ })

}]);
//# sourceMappingURL=city-city-module.js.map