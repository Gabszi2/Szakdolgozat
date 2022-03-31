import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AdminQuestionAddComponent} from './admin-question-add.component';

describe('AdminQuestionAddComponent', () => {
  let component: AdminQuestionAddComponent;
  let fixture: ComponentFixture<AdminQuestionAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminQuestionAddComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminQuestionAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
