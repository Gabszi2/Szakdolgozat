import {ComponentFixture, TestBed} from '@angular/core/testing';

import {CustomerQuestionsFormComponent} from './customer-questions-form.component';

describe('CustomerQuestionsFormComponent', () => {
  let component: CustomerQuestionsFormComponent;
  let fixture: ComponentFixture<CustomerQuestionsFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CustomerQuestionsFormComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerQuestionsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
