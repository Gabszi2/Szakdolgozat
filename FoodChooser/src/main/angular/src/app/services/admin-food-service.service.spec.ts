import { TestBed } from '@angular/core/testing';

import { AdminFoodServiceService } from './admin-food-service.service';

describe('AdminFoodServiceService', () => {
  let service: AdminFoodServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminFoodServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
