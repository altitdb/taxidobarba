import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelPage } from './fuel.page';

describe('FuelPage', () => {
  let component: FuelPage;
  let fixture: ComponentFixture<FuelPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FuelPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FuelPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
