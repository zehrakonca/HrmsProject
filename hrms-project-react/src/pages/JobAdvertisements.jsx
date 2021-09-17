import React from 'react'
import { Button, Segment, Item, Icon, Grid, Header,Checkbox, Dropdown} from 'semantic-ui-react'
import company from '../../src/img/company.png'
export default function JobAdvertisements() {
  return (
    <div>
      <Grid>
        <Grid.Column width={4} centered>
          <Segment>
            <Header as="h4" disabled dividing>Sector</Header>
            <Checkbox label='Sector1' />
            <Header as="h4" disabled dividing>Job</Header>
            <Checkbox label='Title1' />
            <Header as="h4" disabled dividing>City</Header>
            <Dropdown clearable selection></Dropdown>
          </Segment>
        </Grid.Column>
        <Grid.Column width={12} centered>
          <Segment color='teal'>
            <Item.Group divided>
              <Item>
                <Item.Image src={company} size="small" />

                <Item.Content>
                  <Item.Header as='a' floated='left'>job name</Item.Header>
                  <Item.Meta floated='left'>
                    <span className='cinema'>sector</span>
                  </Item.Meta>
                  <Item.Description floated='left'>job description</Item.Description>
                  <Item.Extra>
                    <Button color="teal" floated='right'>
                      examine!
                      <Icon name='right chevron' />
                    </Button>
                  </Item.Extra>
                </Item.Content>
              </Item>
            </Item.Group>
          </Segment>
        </Grid.Column>
      </Grid>
    </div>
  )
}