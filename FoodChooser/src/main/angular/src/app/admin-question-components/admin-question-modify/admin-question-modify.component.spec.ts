import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AdminQuestionModifyComponent} from './admin-question-modify.component';

describe('AdminQuestionModifyComponent', () => {
  let component: AdminQuestionModifyComponent;
  let fixture: ComponentFixture<AdminQuestionModifyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminQuestionModifyComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminQuestionModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
