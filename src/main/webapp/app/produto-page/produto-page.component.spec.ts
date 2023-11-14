import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutoPageComponent } from './produto-page.component';

describe('ProdutoPageComponent', () => {
  let component: ProdutoPageComponent;
  let fixture: ComponentFixture<ProdutoPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProdutoPageComponent]
    });
    fixture = TestBed.createComponent(ProdutoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
