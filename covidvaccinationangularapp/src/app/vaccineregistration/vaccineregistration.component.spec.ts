import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccineregistrationComponent } from './vaccineregistration.component';

describe('VaccineregistrationComponent', () => {
  let component: VaccineregistrationComponent;
  let fixture: ComponentFixture<VaccineregistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccineregistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccineregistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
