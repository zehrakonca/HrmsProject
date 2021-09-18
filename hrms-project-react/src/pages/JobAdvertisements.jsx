import React, { useState, useEffect } from "react";
import { Button, Segment, Item, Icon, Grid, Header, Checkbox, Dropdown, List } from 'semantic-ui-react'
import company from '../../src/img/company.png'
import JobAdvertisementService from "../services/JobAdvertisementService";
import SectorService from "../services/SectorService";
import JobService from "../services/JobService";
import CityService from "../services/CityService";

export default function JobAdvertisements() {
  const [jobAdvertisements, setJobAdvertisements] = useState([])
  const [sectors, setsSectors] = useState([]);
  const [jobs, setJobs] = useState([]);
  const [cities, setCities] = useState([]);

  useEffect(() => {
    let jobAdvertisementService = new JobAdvertisementService()
    jobAdvertisementService.getJobAdvertisements().then(result => setJobAdvertisements(result.data.data))
  }, [])

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
      <Grid>
        <Grid.Column width={4} centered>
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
            <Dropdown
              placeholder="select city"
              name="cityName"
              selection
              options={cities}
            />
            <Button color="teal">Search</Button>
          </Segment>
        </Grid.Column>
        <Grid.Column width={12} centered>
          <Segment color='teal'>
            {jobAdvertisements.map((jobAdvertisement) => (
              <Item.Group dividing>
                <Item>
                  <Item.Image src={company} size="small" />
                  <Item.Content>
                    <Item.Header as='a' floated='left'>{jobAdvertisement.advertisementName}</Item.Header>
                    <Item.Meta floated='left'>
                      <span>{jobAdvertisement.sector.sectorName}, {jobAdvertisement.city.cityName}</span>
                    </Item.Meta>
                    <Item.Description floated='left'>{jobAdvertisement.jobDescription}</Item.Description>
                    <Item.Extra>
                      <Button color="teal" floated='right'>
                        examine!
                        <Icon name='right chevron' />
                      </Button>
                    </Item.Extra>
                  </Item.Content>
                </Item>
              </Item.Group>
            ))}
          </Segment>
        </Grid.Column>
      </Grid>
    </div>
  )
}