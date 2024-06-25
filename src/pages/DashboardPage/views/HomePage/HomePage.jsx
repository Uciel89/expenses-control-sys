import { MinusIcon, PlusIcon } from '@heroicons/react/24/solid'
import React from 'react'

function HomePage() {
  return (
    <section className=' flex flex-col items-center'>
      <div className='flex flex-col'>
        <div className='flex flex-col gap-2'>
          <h1 className='text-xl'>Saldo</h1>
          <h2 className=' text-4xl'>$100.000</h2>
        </div>
        <div className='flex mt-2'>
          <button type="button" class="flex items-center text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2.5 me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800 ">
            <PlusIcon className=" h-8 w-8 py-1 text-gray-900 dark:text-gray-50 cursor-pointer" />
            Cargar un Ingreso
          </button>
          <button type="button" class="flex items-center text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-4 py-2.5 me-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 focus:outline-none dark:focus:ring-red-800 ">
            <MinusIcon className=" h-8 w-8 py-1 text-gray-900 dark:text-gray-50 cursor-pointer" />
            Cargar un Gasto
          </button>
        </div>
        <div className='flex flex-col w-full gap-2 mt-5'>
          <h1 className='text-xl'>Cuentas</h1>
          <div className='flex max-sm:flex-col w-full gap-2'>
            <div className='max-sm:w-full w-80 max-w-screen-xl p-6 bg-gray-100 border border-gray-400 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700'>
              <h1 className='text-xl'>Efectivo</h1>
              <h2 className='text-2xl font-semibold'>$20.000</h2>
            </div>
            <div className='max-sm:w-full w-80 max-w-screen-xl  p-6 bg-gray-100 border border-gray-400 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700'>
              <h1 className='text-xl'>Banco Macro</h1>
              <h2 className='text-2xl font-semibold'>$50.000</h2>
            </div>
            <div className='max-sm:w-full w-80 max-w-screen-xl  p-6 bg-gray-100 border border-gray-400 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700'>
              <h1 className='text-xl'>PayPal</h1>
              <h2 className='text-2xl font-semibold'>20.000</h2>
            </div>
          </div>
        </div>

      </div>
      <div>

      </div>
    </section>
  )
}

export default HomePage