import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IndexService } from '../index.service';
import { environment } from 'src/environments/environment';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-paging',
  templateUrl: './paging.component.html',
  styleUrls: ['./paging.component.css']
})
export class PagingComponent implements OnInit {
  pageSize = 30;
  pageIndex = 0;
  length = 0;


  constructor(private http: HttpClient, private idxService: IndexService) {
    this.http.get<number>(`${environment.endpoint}/feeds/pages`).subscribe(pagesNr => this.length = pagesNr*this.pageSize);
  }

  handlePageEvent(e: PageEvent) {
    // this.pageEvent = e;
    // this.length = e.length;
    // this.pageSize = e.pageSize;
    // this.pageIndex = e.pageIndex;
    this.pageIndex = e.pageIndex;
    this.idxService.goto(this.pageIndex);
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });

  }

  ngOnInit(): void {}

}
