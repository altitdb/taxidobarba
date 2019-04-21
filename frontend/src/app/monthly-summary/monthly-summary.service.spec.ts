import { TestBed } from '@angular/core/testing';

import { MonthlySummaryService } from './monthly-summary.service';

describe('MonthlySummaryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MonthlySummaryService = TestBed.get(MonthlySummaryService);
    expect(service).toBeTruthy();
  });
});
