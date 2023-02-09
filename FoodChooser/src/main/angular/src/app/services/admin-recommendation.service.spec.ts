import { TestBed } from '@angular/core/testing';

import { AdminRecommendationService } from './admin-recommendation.service';

describe('AdminRecommendationService', () => {
  let service: AdminRecommendationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminRecommendationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
