import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MonthlyPage } from './monthly.page';

describe('MonthlyPage', () => {
  let component: MonthlyPage;
  let fixture: ComponentFixture<MonthlyPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MonthlyPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MonthlyPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
