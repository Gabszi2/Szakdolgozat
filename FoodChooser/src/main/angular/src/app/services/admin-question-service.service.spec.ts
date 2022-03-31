import { TestBed } from '@angular/core/testing';

import { AdminQuestionServiceService } from './admin-question-service.service';

describe('AdminQuestionServiceService', () => {
  let service: AdminQuestionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminQuestionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
