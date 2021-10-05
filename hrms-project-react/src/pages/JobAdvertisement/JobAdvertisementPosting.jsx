import React, { useState, useEffect } from 'react';
import { Formik } from "formik";
import * as Yup from 'yup';
import { useHistory } from 'react-router';
import { Segment } from 'semantic-ui-react';
import SectorService from '../../services/SectorService';
import PositionLevelService from '../../services/PositionLevelService';
import EducationLevelService from '../../services/EducationLevelService';
import JobService from '../../services/JobService';
import CityService from '../../services/CityService';
import EmployerService from '../../services/EmployerService';
import JobTypeService from '../../services/JobTypeService';
import MilitaryStatuService from '../../services/MilitaryStatuService';
import WorkTypeService from '../../services/WorkTypeService';
import ExperienceService from '../../services/ExperienceService';
import JobAdvertisementService from '../../services/JobAdvertisementService';
import 'bootstrap/dist/css/bootstrap.min.css';

function JobAdvertisementPosting() {
    const [sectors, setSectors] = useState([]);
    const [positionLevels, setPositionLevels] = useState([]);
    const [educationLevels, setEducationLevels] = useState([]);
    const [employers, setEmployers] = useState([]);
    const [jobs, setJobs] = useState([]);
    const [cities, setCities] = useState([]);
    const [jobTypes, setJobTypes] = useState([]);
    const [militaryStatus, setMilitaryStatus] = useState([]);
    const [workTypes, setWorkTypes] = useState([]);
    const [experiences, setExperiences] = useState([]);

    useEffect(() => {
        let sectorService = new SectorService();
        let positionLevelService = new PositionLevelService();
        let educationLevelService = new EducationLevelService();
        let employerService = new EmployerService();
        let jobService = new JobService();
        let cityService = new CityService();
        let jobTypeService = new JobTypeService();
        let militaryStatuService = new MilitaryStatuService();
        let workTypeService = new WorkTypeService();
        let experienceService = new ExperienceService();

        sectorService.getAllSectors().then((sector) => { setSectors(sector.data.data); });

        positionLevelService.getAllPositionLevels().then((positionLevel) => { setPositionLevels(positionLevel.data.data); })

        educationLevelService.getAllEducationLevels().then((educationLevel) => { setEducationLevels(educationLevel.data.data); })

        jobService.getAllJobs().then((job) => { setJobs(job.data.data); });

        cityService.getAllCities().then((city) => { setCities(city.data.data); })

        jobTypeService.getAllJobTypes().then((jobType) => { setJobTypes(jobType.data.data); })

        militaryStatuService.getAllMilitaryStatu().then((militaryStatu) => { setMilitaryStatus(militaryStatu.data.data); })

        workTypeService.getAllWorkTypes().then((workType) => { setWorkTypes(workType.data.data); })

        experienceService.getAllExperiences().then((experience) => { setExperiences(experience.data.data); })
    }, [])

    const history = useHistory();
    const jobAdvertisementService = new JobAdvertisementService();

    return (
        <div>
            <Segment basic color="green">
                <Formik
                    initialValues={{
                        sectorId: "",
                        positionLevelId: "",
                        educationLevelId: "",
                        employerId: "",
                        jobId: "",
                        cityId: "",
                        jobTypeId: "",
                        militaryStatuId: "",
                        workTypeId: "",
                        experienceId: ""
                    }}
                    validationSchema={
                        Yup.object({
                            advertisementName: Yup.string().required("advertisement name is cannot be blank."),
                            jobDescription: Yup.string().required("job description is cannot be blank."),
                            numberOfVacancies: Yup.number().required("number of  vacancies must be at least 1 person. "),
                            jobSalary: Yup.number(),
                            sectorId: Yup.number().required("sector info is cannot be blank."),
                            positionLevelId: Yup.number().required("position level is cannot be blank."),
                            jobId: Yup.number().required("job name is cannot beblank."),
                            cityId: Yup.number().required("city info is cannot be blank."),
                            jobTypeId: Yup.number().required("job type is cannoy be blank."),
                            militaryStatuId: Yup.number(),
                            workTypeId: Yup.number().required("work type is cannot be blank."),
                            experienceId: Yup.number()
                        })
                    }
                    onSubmit={(
                        values,
                        { setSubmitting, setErrors, setStatus, resetForm }
                    ) => {
                        values.sectorId = parseInt(values.sectorId);
                        values.positionLevelId = parseInt(values.positionLevelId);
                        values.educationLevelId = parseInt(values.educationLevelId);
                        values.employerId = 1;
                        values.jobId = parseInt(values.jobId);
                        values.cityId = parseInt(values.cityId);
                        values.jobTypeId = parseInt(values.jobTypeId);
                        values.militaryStatuId = parseInt(values.militaryStatuId);
                        values.workTypeId = parseInt(values.workTypeId);
                        values.experienceId = parseInt(values.experienceId);

                        jobAdvertisementService.addAdvertisement(values).then((data) =>
                            console.log(data),
                            history.push("/advertisements")
                        )
                    }
                    }
                >
                    {({
                        values,
                        touched,
                        errors,
                        dirty,
                        isSubmitting,
                        handleSubmit,
                        handleReset,
                        handleChange,
                    }) => (
                        <form onSubmit={handleSubmit}>
                            <div className="row">
                                <div className="col-md-6">
                                    <div>
                                        <label>Advertisement Name : </label>
                                        <input 
                                        type="text" 
                                        className="form-control" 
                                        aria-label="please enter advertisement name" 
                                        name="advertisementName"
                                        onChange={handleChange}
                                        values={values.advertisementName}
                                        />
                                    </div>
                                    <div>
                                        <label>Sector Info : </label>
                                        <select
                                            id="sectorId"
                                            name="sectorId"
                                            value={values.sectorId}
                                            onChange={handleChange}
                                            className="form-control"
                                        >
                                            <option value="" label="Choose sector" />
                                            {sectors.map((data, index) =>
                                            (
                                                <option key={index} value={data.sectorId} label={data.sectorName}>
                                                    {data.sectorName}
                                                </option>
                                            )
                                            )}
                                        </select>
                                    </div>
                                    <div>
                                        <label>City Info: </label>
                                        <select
                                            id="cityId"
                                            name="cityId"
                                            value={values.cityId}
                                            onChange={handleChange}
                                            className="form-control"
                                        >
                                            <option value="" label="Choose city info" />
                                            {cities.map((data, index) =>
                                                <option key={index} value={data.cityId}>
                                                    {data.cityName}
                                                </option>
                                            )}
                                        </select>
                                    </div>
                                    <div>
                                        <label>Job Type Info: </label>
                                        <select
                                            id="jobTypeId"
                                            name="jobTypeId"
                                            value={values.jobTypeId}
                                            onChange={handleChange}
                                            className="form-control"
                                        >
                                            <option value="" label="Choose job type info" />
                                            {jobTypes.map((data, index) =>
                                                <option key={index} value={data.typeId} label={data.typeName}>
                                                    {data.typeName}
                                                </option>
                                            )}
                                        </select>
                                    </div>
                                    <div>
                                        <label>Military Statu Info: </label>
                                        <select
                                            id="militaryStatuId"
                                            name="militaryStatuId"
                                            value={values.militaryStatuId}
                                            onChange={handleChange}
                                            className="form-control"
                                        >
                                            <option value="" label="Choose city info" />
                                            {militaryStatus.map((data, index) =>
                                                <option key={index} value={data.militaryStatuId}>
                                                    {data.militaryStatuName}
                                                </option>
                                            )}
                                        </select>
                                    </div>
                                    <div>
                                        <label>Work Type Info: </label>
                                        <select
                                            id="workTypeId"
                                            name="workType"
                                            value={values.workType}
                                            onChange={handleChange}
                                            className="form-control"
                                        >
                                            <option value="" label="Choose work type info" />
                                            {workTypes.map((data, index) =>
                                                <option key={index} value={data.workTypeId}>
                                                    {data.workTypeName}
                                                </option>
                                            )}
                                        </select>
                                    </div>
                                    <div>
                                        <label>Experience Info: </label>
                                        <select
                                            id="experienceId"
                                            name="experienceId"
                                            value={values.experienceId}
                                            onChange={handleChange}
                                            className="form-control"
                                        >
                                            <option value="" label="Choose experience info" />
                                            {experiences.map((data, index) =>
                                                <option key={index} value={data.experienceId}>
                                                    {data.experienceName}
                                                </option>
                                            )}
                                        </select>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div>
                                        <label>Advertisement Info: </label>
                                        <textarea
                                            className="form-control"
                                            type="text"
                                            name="jobDescription"
                                            onChange={handleChange}
                                            values={values.jobDescription}
                                        ></textarea>
                                    </div>
                                    <div>
                                        <label>Number of Vacancies : </label>
                                        <input
                                            type="text"
                                            className="form-control"
                                            aria-label="number of vacancies(only number)"
                                            type="text"
                                            name="numberOfVacancies"
                                            onChange={handleChange}
                                            values={values.numberOfVacancies}
                                        />
                                    </div>
                                    <div>
                                        <label>Position Level Info: </label>
                                        <select
                                            id="positionLevelId"
                                            name="positionLevelId"
                                            value={values.positionLevelId}
                                            onChange={handleChange}
                                            className="form-control"
                                        >
                                            <option value="" label="Choose position level info" />
                                            {positionLevels.map((data, index) =>
                                                <option key={index} value={data.levelId} label={data.positionlevelName}>
                                                    {data.positionlevelName}
                                                </option>
                                            )}
                                        </select>
                                    </div>
                                    <div>
                                        <label>Education Level Info: </label>
                                        <select
                                            id="educationLevelId"
                                            name="educationLevelId"
                                            value={values.educationLevelId}
                                            onChange={handleChange}
                                            className="form-control"
                                        >
                                            <option value="" label="Choose education level info" />
                                            {educationLevels.map((data, index) =>
                                                <option key={index} value={data.levelId}>
                                                    {data.educationLevelName}
                                                </option>
                                            )}
                                        </select>
                                    </div>
                                    <div>
                                        <label>Job Info: </label>
                                        <select
                                            id="jobId"
                                            name="jobId"
                                            value={values.jobId}
                                            onChange={handleChange}
                                            className="form-control"
                                        >
                                            <option value="" label="Choose job info" />
                                            {jobs.map((data, index) =>
                                                <option key={index} value={data.jobId}>
                                                    {data.jobName}
                                                </option>
                                            )}
                                        </select>
                                    </div>
                                    <div>
                                        <label>Job Salary : </label>
                                        <input
                                            type="text"
                                            className="form-control"
                                            aria-label="job salary (only number)"
                                            name="jobSalary"
                                            onChange={handleChange}
                                            values={values.jobSalary}
                                        />
                                    </div>
                                    <div className="row">
                                        <div>
                                        <label>Release Date : </label>
                                        <input
                                            type="datetime-local"
                                            className="form-control"
                                            name="releaseDate"
                                            onChange={handleChange}
                                            values={values.releaseDate}
                                        />
                                        </div>
                                        <div>
                                        <label>Application Date : </label>
                                        <input
                                            type="datetime-local"
                                            className="form-control"
                                            name="applicationDate"
                                            onChange={handleChange}
                                            values={values.applicationDate}
                                        />
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <button
                                        type="submit"
                                        disabled={!dirty || isSubmitting}
                                        className="btn btn-outline-success"
                                    >
                                        Create</button>
                                </div>
                            </div>
                        </form>
                    )
                    }
                </Formik>
            </Segment>
        </div>
    )
}

export default JobAdvertisementPosting;
