// import FullCalendar from "@fullcalendar/react";
// import dayGridPlugin from '@fullcalendar/daygrid'
// import interactionPlugin from '@fullcalendar/interaction'
// import "react-calendar/dist/Calendar.css";
// import { useState } from "react";
// import PlanPop from "./PlanPop";




const Plan = () => {
  // const [events, setEvents] = useState([
  //   { id: 1, title: '아침: 샐러드 점심: 운동', startDate: '2024-04-05', startTime: '09:00', endDate: '2024-04-05', endTime: '10:00' },
  //   { id: 2, title: '아침: 샐러드 점심: 운동', startDate: '2024-04-06', startTime: '09:00', endDate: '2024-04-05', endTime: '10:00' },
  //   { id: 3, title: '아침: 샐러드 점심: 운동', startDate: '2024-01-20', startTime: '09:00', endDate: '2024-04-05', endTime: '10:00' },
  // ])
  // const [idNumber, setIdNumber] = useState(1);
  // const storedEvents = JSON.parse(localStorage.getItem('events'));
  // const initialEvents = storedEvents ? storedEvents : [];
  // const [eventts, setEventts] = useState(initialEvents);


  // const [isPopupOpen, setIsPopupOpen] = useState(false);
  // const [deleteBtnVisible, setDeleteBtnVisible] = useState(false);
  // const [formData, setFormData] = useState({
  //   title: '',
  //   startDate: '',
  //   startTime: '',
  //   endDate: '',
  //   endTime: ''
  // })
  // const [editingEvent, setEditingEvent] = useState(null);

  // const modalOpen = () => {
  //   setIsPopupOpen(true);
  // };

  // const modalClose = () => {
  //   setIsPopupOpen(false);
  // };

  // const onDateClick = (arg) => {
  //   setEditingEvent(null);
  //   setDeleteBtnVisible(false);
  //   setFormData({
  //     title: '',
  //     startDate: arg.dateStr,
  //     startTime: arg.dateStr,
  //     endDate: arg.dateStr,
  //     endTime: arg.dateStr
  //   })
  //   modalOpen();
  // };

  // const onChange = (e) => {
  //   const { name, value } = e.target;
  //   setFormData({
  //     ...formData,
  //     [name]: value
  //   })
  // };

  // const onSubmitEvent = (e) => {
  //   e.preventDefault();

  //   if (editingEvent) {
  //     setDeleteBtnVisible(true);
  //     const updatedEvents = events.map((event) => {
  //       console.log(event.id, editingEvent.id);
  //       if (event.id === parseInt(editingEvent.id, 10)) {
  //         return { ...event,
  //           title: formData.title,
  //           startDate: formData.startDate,
  //           startTime: formData.startTime,
  //           endDate: formData.endDate,
  //           endTime: formData.endTime
  //         };
  //       } else {

  //         return event;
  //       }
  //     });
  //     setEvents(updatedEvents);
  //   } else {
  //     setDeleteBtnVisible(false);
  //     console.log('editing no')
  //     const newEvent = {
  //       id: events.length + 1,
  //       title: formData.title,
  //       startDate: formData.startDate,
  //       startTime: formData.startTime,
  //       endDate: formData.endDate,
  //       endTime: formData.endTime
  //     };
  //     setEvents((prevEvents) => [...prevEvents, newEvent]);
  //   }
  //   modalClose();
  // };

  // const onEventClick = (info) => {
  //   console.log(info.event);
  //   setEditingEvent(info.event);
  //   setDeleteBtnVisible(true);
  //   setFormData({
  //     title: info.event.title,
  //     startDate: new Date(info.event.startDate).toLocaleDateString('en-CA'),
  //     startTime: new Date(info.event.startTime).toLocaleTimeString('en-CA'),
  //     endDate: new Date(info.event.endDate).toLocaleDateString('en-CA'),
  //     endTime: new Date(info.event.endTime).toLocaleTimeString('en-CA')
  //   });
  //   modalOpen();
  // };

  // const onDeleteEvent = () => {
  //   const updatedEvents = events.filter((event) => event.id !== parseInt(editingEvent.id, 10));
  //   setEvents(updatedEvents);
  //   modalClose();
  // }

  // const renderDayContent = (arg) => {
  //   const date = arg.date.getDate();
  //   return (
  //     <span className='date'>{date}</span>
  //   )
  // };



  // return (
  //   <>
  //     <div className="inner_m" id="plan">
  //       <h1>빈즈플래너</h1>
  //       <div className="planner_left">
  //         <FullCalendar
  //           locale="ko"
  //           plugins={[dayGridPlugin, interactionPlugin]}
  //           initialView='dayGridMonth'
  //           selectable={true}
  //           editable={true}
  //           events={events}
  //           eventLimit={true}
  //           dateClick={onDateClick}
  //           eventClick={onEventClick}
  //           titleFormat={{
  //             month: 'numeric',
  //             year: 'numeric'
  //           }}
  //           dayCellContent={renderDayContent}
  //         />
  //         {isPopupOpen && (
  //           <PlanPop
  //             title={formData.title}
  //             startDate={formData.startDate}
  //             startTime={formData.startTime}
  //             endDate={formData.endDate}
  //             endTime={formData.endTime}
  //             onChange={onChange}
  //             onSubmit={onSubmitEvent}
  //             onDeleteEvent={onDeleteEvent}
  //             modalClose={modalClose}
  //             onEventClick={onEventClick}
  //             deleteBtnVisible={deleteBtnVisible}
  //           />)}
  //       </div>
  //       <div className="planner_right">
  //         <p>RIGHT</p>
  //       </div>
  //     </div>
  //   </>
  // )
}

export default Plan