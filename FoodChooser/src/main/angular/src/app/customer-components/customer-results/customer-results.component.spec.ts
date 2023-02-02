import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerResultsComponent } from './customer-results.component';

describe('CustomerResultsComponent', () => {
  let component: CustomerResultsComponent;
  let fixture: ComponentFixture<CustomerResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerResultsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
