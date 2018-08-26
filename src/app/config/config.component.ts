import { Config } from './../interfaces/Config';
import { ConfigService } from './../config.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css']
})
export class ConfigComponent implements OnInit {

  config: Config;

  constructor(private configService : ConfigService) { }

  ngOnInit() {
    console.log(this.showConfig());
    
  }

  
  
  showConfig() {
    this.configService.getConfig()
      // clone the data object, using its known Config shape
      .subscribe((data: Config) => this.config = { ...data });
  }
  
 
  

}
