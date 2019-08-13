import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SecurityMarketComponent } from './security-market.component';

describe('SecurityMarketComponent', () => {
  let component: SecurityMarketComponent;
  let fixture: ComponentFixture<SecurityMarketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecurityMarketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecurityMarketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
