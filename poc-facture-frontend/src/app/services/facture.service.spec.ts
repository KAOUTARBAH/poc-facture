import { TestBed } from '@angular/core/testing';

import { FactureService } from './facture.service';

describe('FacturesService', () => {
  let service: FactureService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FactureService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
