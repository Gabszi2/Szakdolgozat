import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AdminCityModifyComponent} from './admin-city-modify.component';

describe('AdminCityModifyComponent', () => {
  let component: AdminCityModifyComponent;
  let fixture: ComponentFixture<AdminCityModifyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminCityModifyComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCityModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
