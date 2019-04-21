import { TestBed } from '@angular/core/testing';

import { AnnualSummaryService } from './annual-summary.service';

describe('AnnualSummaryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AnnualSummaryService = TestBed.get(AnnualSummaryService);
    expect(service).toBeTruthy();
  });
});
