import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendaPageComponent } from './venda-page.component';

describe('VendaPageComponent', () => {
  let component: VendaPageComponent;
  let fixture: ComponentFixture<VendaPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VendaPageComponent]
    });
    fixture = TestBed.createComponent(VendaPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
