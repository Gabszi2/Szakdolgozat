import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AdminQuestionStartComponent} from './admin-question-start.component';

describe('AdminQuestionStartComponent', () => {
  let component: AdminQuestionStartComponent;
  let fixture: ComponentFixture<AdminQuestionStartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminQuestionStartComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminQuestionStartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
