import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentNewsFormComponent } from './comment-news-form.component';

describe('CommentNewsFormComponent', () => {
  let component: CommentNewsFormComponent;
  let fixture: ComponentFixture<CommentNewsFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommentNewsFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommentNewsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
