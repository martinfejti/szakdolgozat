import { TestBed } from '@angular/core/testing';

import { RunTestService } from './run-test.service';

describe('RunTestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RunTestService = TestBed.get(RunTestService);
    expect(service).toBeTruthy();
  });
});
