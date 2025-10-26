import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KeynoteDetaillsComponent } from './keynote-detaills.component';

describe('KeynoteDetaillsComponent', () => {
  let component: KeynoteDetaillsComponent;
  let fixture: ComponentFixture<KeynoteDetaillsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KeynoteDetaillsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KeynoteDetaillsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
