import { TestBed } from '@angular/core/testing';

import { VaccineregistrationService } from './vaccineregistration.service';

describe('VaccineregistrationService', () => {
  let service: VaccineregistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VaccineregistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
