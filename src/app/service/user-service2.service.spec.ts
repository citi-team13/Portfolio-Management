import { TestBed } from '@angular/core/testing';

import { UserService2Service } from './user-service2.service';

describe('UserService2Service', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserService2Service = TestBed.get(UserService2Service);
    expect(service).toBeTruthy();
  });
});
