import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentNewsListComponent } from './comment-news-list.component';

describe('CommentNewsListComponent', () => {
  let component: CommentNewsListComponent;
  let fixture: ComponentFixture<CommentNewsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommentNewsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommentNewsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
