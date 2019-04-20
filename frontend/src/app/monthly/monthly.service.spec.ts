import { TestBed } from '@angular/core/testing';

import { MonthlyService } from './monthly.service';

describe('MonthlyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MonthlyService = TestBed.get(MonthlyService);
    expect(service).toBeTruthy();
  });
});
