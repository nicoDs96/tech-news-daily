import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { IndexService } from '../index.service';
import { Feed } from './Feed';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  feedList: Feed[];
  index: number;
  constructor(private http: HttpClient, private idxService: IndexService) {
    this.feedList = [];
    this.index = 0;
  }

  ngOnInit(): void {
    this.idxService.idx.subscribe(value => {
      this.index = value;
      this.http.get<Feed []>(`${environment.endpoint}/feeds/${this.index}`)
        .subscribe(feeds => this.feedList = feeds);
    })
  }

  goToArticle(src: string){
    window.open(src, '_blank');
  }

}
