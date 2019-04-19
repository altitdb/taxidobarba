import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelPage } from './travel.page';

describe('TravelPage', () => {
  let component: TravelPage;
  let fixture: ComponentFixture<TravelPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravelPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravelPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
