import { TestBed } from '@angular/core/testing';

import { MonthlyGoalService } from './monthly-goal.service';

describe('MonthlyGoalService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MonthlyGoalService = TestBed.get(MonthlyGoalService);
    expect(service).toBeTruthy();
  });
});
