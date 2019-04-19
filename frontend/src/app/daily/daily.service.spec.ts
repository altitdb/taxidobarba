import { TestBed } from '@angular/core/testing';

import { DailyService } from './daily.service';

describe('DailyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DailyService = TestBed.get(DailyService);
    expect(service).toBeTruthy();
  });
});
