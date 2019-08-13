import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundChartComponent } from './fund-chart.component';

describe('FundChartComponent', () => {
  let component: FundChartComponent;
  let fixture: ComponentFixture<FundChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
