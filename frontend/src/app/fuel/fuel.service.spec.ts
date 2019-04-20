import { TestBed } from '@angular/core/testing';

import { FuelService } from './fuel.service';

describe('FuelService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FuelService = TestBed.get(FuelService);
    expect(service).toBeTruthy();
  });
});
