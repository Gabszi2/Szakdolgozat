import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AdminApprovedRecComponent} from './admin-approved-rec.component';

describe('AdminApprovedRecComponent', () => {
  let component: AdminApprovedRecComponent;
  let fixture: ComponentFixture<AdminApprovedRecComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminApprovedRecComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminApprovedRecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
