import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCityListComponent } from './admin-city-list.component';

describe('AdminCityListComponent', () => {
  let component: AdminCityListComponent;
  let fixture: ComponentFixture<AdminCityListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCityListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCityListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
