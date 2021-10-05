import React, { useState, useEffect } from 'react'
import { Checkbox, Dropdown,Segment,Header,List,Button } from 'semantic-ui-react'
import SectorService from "../../src/services/SectorService"
import JobService from '../services/JobService';
import CityService from '../services/CityService';

export default function Sidebar() {

  const [sectors, setsSectors] = useState([]);
  const [jobs, setJobs] = useState([]);
  const [cities, setCities] = useState([]);

  useEffect(() => {
    let sectorService = new SectorService();
    sectorService.getAllSectors().then((result) => setsSectors(result.data.data));
  });

  useEffect(() => {
    let jobService = new JobService();
    jobService.getAllJobs().then((result) => setJobs(result.data.data));
  });

  useEffect(() => {
    let cityService = new CityService();
    cityService.getAllCities().then((result) => setCities(result.data.data));
  });
  return (
    <div>
      <Segment>
        <Header as="h4" disabled dividing>Sector</Header>
        <List>
          {sectors.map((sector) => (
            <List.Item>
              <Checkbox label={sector.sectorName} />
            </List.Item>
          ))}
        </List>
        <Header as="h4" disabled dividing>Job</Header>
        <List>
          {jobs.map((job) => (
            <List.Item>
              <Checkbox label={job.jobName} />
            </List.Item>
          ))}
        </List>
        <Header as="h4" disabled dividing>City</Header>
        <Button color="teal">Search</Button>
      </Segment>
    </div>
  )
}
