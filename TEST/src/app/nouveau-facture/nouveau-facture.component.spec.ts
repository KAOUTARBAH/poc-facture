import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauFactureComponent } from './nouveau-facture.component';

describe('NouveauFactureComponent', () => {
  let component: NouveauFactureComponent;
  let fixture: ComponentFixture<NouveauFactureComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NouveauFactureComponent]
    });
    fixture = TestBed.createComponent(NouveauFactureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
